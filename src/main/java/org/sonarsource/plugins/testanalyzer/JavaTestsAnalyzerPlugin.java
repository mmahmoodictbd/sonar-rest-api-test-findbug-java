package org.sonarsource.plugins.testanalyzer;

import org.sonar.api.Plugin;

public class JavaTestsAnalyzerPlugin implements Plugin {

    @Override
    public void define(Context context) {

        // server extensions -> objects are instantiated during server startup
        context.addExtension(JavaTestsAnalyzerRulesDefinition.class);

    }

}
