import groovy.json.JsonOutput

folder("${BUILD_FOLDER}")

pipelineJob("${BUILD_FOLDER}/${JOB_NAME}") {
    description('<h1>THIS IS AN AUTOMATICALLY GENERATED JOB DO NOT MODIFY, IT WILL BE OVERWRITTEN.</h1><p>This job is defined in weekly_release_pipeline_job_template.groovy in the ci-jenkins-pipelines repo, if you wish to change it modify that.</p>')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url("${GIT_URL}")
                        credentials("${CHECKOUT_CREDENTIALS}")
                    }
                    branch("${BRANCH}")
                    extensions {
                        // delete the content of the workspace before building
                        wipeOutWorkspace()
                    }
                }
            }
            scriptPath(SCRIPT)
            lightweight(false)
        }
    }
    disabled(disableJob)

    logRotator {
        numToKeep(60)
        artifactNumToKeep(2)
    }

    properties {
        pipelineTriggers {
            triggers {
                cron {
                    spec(pipelineSchedule)
                }
            }
        }
    }

    parameters {
        stringParam('buildPipeline', "${BUILD_FOLDER}/${PIPELINE}", 'The build pipeline to invoke.')
        textParam('scmReferences', JsonOutput.prettyPrint(JsonOutput.toJson(weekly_release_scmReferences)), 'The map of scmReferences for each variant.')
        textParam('targetConfigurations', JsonOutput.prettyPrint(JsonOutput.toJson(targetConfigurations)), 'The map of platforms and variants to build.')
        textParam('defaultsJson', JsonOutput.prettyPrint(JsonOutput.toJson(defaultsJson)), '<strong>DO NOT ALTER THIS PARAM UNLESS YOU KNOW WHAT YOU ARE DOING!</strong> This passes down the user\'s default constants to the downstream jobs.')
    }
}
