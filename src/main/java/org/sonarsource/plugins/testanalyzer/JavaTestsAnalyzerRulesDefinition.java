package org.sonarsource.plugins.testanalyzer;

import com.google.common.collect.ImmutableList;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.squidbridge.annotations.AnnotationBasedRulesDefinition;
import org.sonarsource.plugins.testanalyzer.checks.ForbiddenSendKeysMethodCheck;

public class JavaTestsAnalyzerRulesDefinition implements RulesDefinition {

    @Override
    public void define(Context context) {

        NewRepository repo = context.createRepository(repositoryKey(), "java").setName(repositoryName());

        new AnnotationBasedRulesDefinition(repo, "java")
                .addRuleClasses(false, ImmutableList.copyOf(checkClasses()));

        repo.done();

    }

    public String repositoryName() {
        return "TestAnalyzer";
    }

    public String repositoryKey() {
        return "test-analyzer";
    }

    public Class[] checkClasses() {
        return new Class[]{
                ForbiddenSendKeysMethodCheck.class,
        };
    }
}