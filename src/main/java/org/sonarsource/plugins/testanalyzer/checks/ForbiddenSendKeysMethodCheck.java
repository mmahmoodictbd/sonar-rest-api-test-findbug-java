package org.sonarsource.plugins.testanalyzer.checks;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;

@Rule(key = "send-keys",
        name = "sendKeys() should not be used",
        description = "sendKeys() should not be used",
        priority = Priority.MAJOR,
        tags = {"bug"})
public class ForbiddenSendKeysMethodCheck extends BaseTreeVisitor implements JavaFileScanner {

    private JavaFileScannerContext context;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    @Override
    public void visitMethodInvocation(MethodInvocationTree tree) {

        IdentifierTree memberSelect = (IdentifierTree) tree.methodSelect();

        if ("sendKeys".equals(memberSelect.name())) {
            context.reportIssue(this, tree, "Should not use sendKeys.");
        }

        super.visitMethodInvocation(tree);
    }
}
