import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Plugin to add dependencies between modules
 * @see [https://medium.com/@magicbluepenguin/how-to-create-your-first-custom-gradle-plugin-efc1333d4419]
 * @see [https://quickbirdstudios.com/blog/gradle-kotlin-buildsrc-plugin-android/]
 *
 */

class TemplatePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        //project.dep
    }
}