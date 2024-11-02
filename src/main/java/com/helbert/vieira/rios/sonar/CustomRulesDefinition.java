package com.helbert.vieira.rios.sonar;

import static com.helbert.vieira.rios.sonar.CustomRules.REPOSITORY_KEY;
import static com.helbert.vieira.rios.sonar.CustomRules.checkClassesAllArray;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionAnnotationLoader;

public class CustomRulesDefinition implements RulesDefinition {

    @Override
    public void define(Context context) {
        final NewRepository repository = context.createRepository(REPOSITORY_KEY, "java")
                .setName("Sonar Custom Rules for java.");

        final Class<?>[] checks = checkClassesAllArray();
        new RulesDefinitionAnnotationLoader().load(repository, checks);

        repository.done();
    }

}
