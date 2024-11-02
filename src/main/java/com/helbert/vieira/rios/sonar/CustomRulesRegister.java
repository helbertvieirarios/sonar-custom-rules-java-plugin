package com.helbert.vieira.rios.sonar;

import static com.helbert.vieira.rios.sonar.CustomRules.REPOSITORY_KEY;
import static com.helbert.vieira.rios.sonar.CustomRules.checkClasses;
import static com.helbert.vieira.rios.sonar.CustomRules.testCheckClasses;

import org.sonar.api.batch.rule.CheckFactory;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonarsource.api.sonarlint.SonarLintSide;

@SonarLintSide
public class CustomRulesRegister implements CheckRegistrar {

    @Override
    public void register(final RegistrarContext registrarContext) {
        registrarContext.registerClassesForRepository(
                REPOSITORY_KEY,
                checkClasses(),
                testCheckClasses()
        );
    }

    @Override
    public void customRulesDefinition(
            final RulesDefinition.Context context,
            final RulesDefinition.NewRepository javaRepository
    ) {
        CheckRegistrar.super.customRulesDefinition(context, javaRepository);
    }

    @Override
    public void register(final RegistrarContext registrarContext, final CheckFactory checkFactory) {
        CheckRegistrar.super.register(registrarContext, checkFactory);
    }

}
