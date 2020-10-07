import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.1"

project {

    vcsRoot(ElefantRepo)

    features {
        feature {
            id = "PROJECT_EXT_31"
            type = "CloudImage"
            param("subnetId", "default")
            param("imageId", "/subscriptions/759c9fa9-8b8a-4ebf-a162-52b3b8da0936/resourceGroups/CHUBATOVA_GROUP/providers/Microsoft.Compute/images/chubatovaLinuxagent-image-20200925163231")
            param("memory", "2")
            param("numberCores", "2")
            param("groupId", "chubatova_group")
            param("agent_pool_id", "-2")
            param("customEnvironmentVariables", "")
            param("vmUsername", "jetbrains")
            param("reuseVm", "false")
            param("source-id", "crocoImage")
            param("deployTarget", "SpecificGroup")
            param("vmPublicIp", "false")
            param("profileId", "arm-9")
            param("imageUrl", "")
            param("osType", "Linux")
            param("networkId", "/subscriptions/759c9fa9-8b8a-4ebf-a162-52b3b8da0936/resourceGroups/chubatova-tc_group/providers/Microsoft.Network/virtualNetworks/chubatova-tc_group-vnet")
            param("storageAccountType", "Premium_LRS")
            param("vmSize", "Standard_B1ms")
            param("maxInstances", "3")
            param("region", "westeurope")
            param("imageType", "Image")
        }
        feature {
            id = "PROJECT_EXT_32"
            type = "CloudImage"
            param("imageId", "jetbrains/teamcity-agent")
            param("memory", "2")
            param("numberCores", "2")
            param("groupId", "chubatova_group")
            param("agent_pool_id", "-2")
            param("customEnvironmentVariables", "")
            param("vmUsername", "")
            param("reuseVm", "false")
            param("source-id", "crocoCont")
            param("deployTarget", "SpecificGroup")
            param("vmPublicIp", "false")
            param("profileId", "arm-9")
            param("imageUrl", "")
            param("osType", "Linux")
            param("maxInstances", "3")
            param("region", "westeurope")
            param("imageType", "Container")
        }
        feature {
            id = "arm-9"
            type = "CloudProfile"
            param("profileServerUrl", "")
            param("system.cloud.profile_id", "arm-9")
            param("total-work-time", "")
            param("credentialsType", "msi")
            param("description", "")
            param("cloud-code", "arm")
            param("enabled", "true")
            param("environment", "AZURE")
            param("agentPushPreset", "")
            param("profileId", "arm-9")
            param("name", "CrocodileCloudProfile")
            param("next-hour", "")
            param("subscriptionId", "759c9fa9-8b8a-4ebf-a162-52b3b8da0936")
            param("terminate-idle-time", "30")
            param("secure:passwords_data", "credentialsJSON:9e0a9ff8-37aa-49e0-8ae9-076b7dc7830b")
        }
    }
}

object ElefantRepo : GitVcsRoot({
    name = "elefantRepo"
    url = "https://github.com/AChubatova/ElefantRepo"
    branch = "refs/heads/main"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:cc84119f-86d3-46f0-b18a-67ca4b6fbc8f"
    }
})
