# ISSUES: Sonarqube is not pointing out custom rules issues in the analysis

## Configure the Gradle Task *sonarqube*

To configure the Gradle task *sonarqube*, follow this tutorial: [Click here to access the tutorial](README.md#sonarqube-configuration). Once configured, run:

```bash
./gradlew sonarqube
```

## Create a Quality Profile

Access `http://localhost:9000` and log in to your SonarQube account. Once logged in, go to the **Quality Profiles** tab and click the **Create** button.

![Create Profile Button](images/click-button-create-profile.png)

Fill in the required input fields as shown in the image above, then click the **Create** button.

![New Profile Form](images/new-profile.png)

Next, click on the **xxx inactive rules** link in the profile you just created.

![Add Custom Rules](images/add-custom-rules.png)

Search for `AvoidOldDateApi` and click the **Activate** button.

![Activate Custom Rules](images/activate-custom-rule.png)

A confirmation dialog will appear. Click the **Activate** button to proceed.

![Confirm Activate Custom Rules](images/confirm-activate-custom-rules.png)

Here's the revised and improved text:


Navigate to the **Projects** tab and click on the link for your project, **sonar-custom-rules-java-plugin**.
![Select Project](images/select-project.png)


>If your project does not appear, run the following command to ensure it is analyzed:
>
>```bash
>./gradlew sonarqube
>```



Expand the project settings by clicking on the settings icon, then select **Quality Profiles**.

![Select Quality Profile](images/select-quality-profile.png)

Click on the edit icon to configure the quality profile.

![Edit Quality Profile](images/configure-quality-profile.png)

Select the quality profile you just created and click the **Save** button.

![Configure Project with Quality Profile](images/configure-project-with-quality-profile.png)

You should now see an increase in the number of active rules.

![Project Quality Profile Changed](images/project-quality-profile-changed.png)

Note that there are no issues reported in the project.

![No Issues in Project](images/no-issues-in-project.png)

Even though there is non-compliant code in the project, SonarQube does not highlight it.

![Non-compliant Code](images/non-compliant-code.png)

However, SonarLint successfully detects and points out the issue.

![Works with SonarLint](images/works-with-sonarlint.png)

I selected all permissions and regenerated the token, but the issue persisted.

![Select Permissions](images/select-permissions.png)

![Permissions](images/permissions.png)
