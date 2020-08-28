# Non-breakable-spaces Highlighter Plugin

## IMPORTANT NOTICE

I do not support this project any longer as Jetbrains released a fix in 2020.2. With this upgrade you will see a |NBSP| block, making this plugin irrelevant. Still, thanks for your interest!


## Description

This is a Jetbrains plugin allowing users to highlight all usages of non-breakable spaces.

### Requirements

* JDK 1.8
* IntelliJ IDEA with Gradle

### Developing using IntelliJ Gradle

You can simplify development process thanks to Intellij's **Gradle plugin**. Install the plugin, restart the IDE and you will be prompted with a window asking if you want to import the project as a Gradle project. After that IntelliJ will download the Gradle Wrapper and the tasks will appear in the Gradle Tool Panel on the right.

Import the project from the `build.gradle` file and develop as normal.  Make sure you select JDK 8 in the import wizard.  The other defaults are fine.  You can run the above mentioned CLI Gradle tasks directly in the Gradle Tool Window, which expands from the right side of the screen.  To debug, find "`runIde`" in the list, right-click it, and choose Run/Debug.

### Testing the plugin

Once you've done developing, you can test the plugin on a real IDE instead of the sandbox. To do so, first select the `buildPlugin` task in the Gradle Tool Window. If everything went fine, it would create a new build of the plugin named `<PluginName>-<version>.jar` inside the `build/distributions` folder.

Then open the plugins page (Settings > Plugin) and select `Install plugin from disk`, then select the jar file and restart the IDE. If all worked well you should see your additions in the Color Scheme Settings.

### Credits

Thanks to mallowigi (Elior Boukhobza) (https://github.com/mallowigi) for the Custom-Syntax-Highlighter, as it provided me a great basis to start this project.

--------------------
