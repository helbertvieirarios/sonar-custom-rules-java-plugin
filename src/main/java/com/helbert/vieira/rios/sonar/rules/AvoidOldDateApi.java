package com.helbert.vieira.rios.sonar.rules;

import java.util.List;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.Tree;

@Rule(
        key = "AvoidOldDateApi",
        name = "Avoid usage of java.util.Date",
        description = "This rule prevents the use of java.util.Date. Use java.time APIs instead.",
        priority = Priority.MINOR,
        tags = { "helbert" })
public class AvoidOldDateApi extends IssuableSubscriptionVisitor {


    @Override
    public List<Tree.Kind> nodesToVisit() {
        return List.of(Tree.Kind.IDENTIFIER);
    }

    @Override
    public void visitNode(Tree tree) {
        if (tree instanceof IdentifierTree identifierTree
                && "Date".equals(identifierTree.name())
                && isJavaUtilDate(identifierTree)
                && !hasAlreadyReportedIssue(identifierTree)) {

            reportIssue(identifierTree, "Avoid using java.util.Date; use java.time.LocalDate or java.time.Instant instead.");
        }
    }

    private boolean isJavaUtilDate(IdentifierTree tree) {
        return  "java.util.Date".equals(tree.symbolType().fullyQualifiedName());
    }

    private boolean hasAlreadyReportedIssue(IdentifierTree tree) {
        return tree.parent() != null && tree.parent().firstToken().text().contains("Date");
    }
}
