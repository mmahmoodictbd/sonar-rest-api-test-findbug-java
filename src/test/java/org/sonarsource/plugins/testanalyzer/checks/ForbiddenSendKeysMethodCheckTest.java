package org.sonarsource.plugins.testanalyzer.checks;

import org.assertj.core.api.Fail;
import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ForbiddenSendKeysMethodCheckTest {


    @Test
    public void verify() {

        try {
            JavaCheckVerifier.verify("src/test/files/ForbiddenSendKeysMethod.java", new ForbiddenSendKeysMethodCheck());
            Fail.fail("");
        } catch (AssertionError e) {
            assertThat(e).hasMessage("Unexpected at [5]");
        }

    }
}