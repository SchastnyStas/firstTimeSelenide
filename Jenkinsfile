pipeline {
   agent any

   tools {
      maven "M3"
   }

   triggers {
       cron('0 8 * * *') // Запуск каждый день в 8 утра
   }

   parameters {
       gitParameter branchFilter: 'origin/(.*)',
                    defaultValue: 'master',
                    name: 'BRANCH',
                    type: 'PT_BRANCH',
                    sortMode: 'DESCENDING_SMART',
                    selectedValue: 'TOP'
   }

   stages {
      stage('Checkout') {
         steps {
            git branch: "${params.BRANCH}", url: 'https://github.com/SchastnyStas/firstTimeSelenide.git'
         }
      }

      stage('Testing') {
         steps {
            script {
                if (isUnix()) {
                    sh "mvn clean -Dtest=ContactTest test"
                } else {
                    bat "mvn clean -Dtest=ContactTest test"
                }
            }
         }

         post {
            always {
                junit '**/target/surefire-reports/TEST-*.xml'
            }
         }
      }

      stage('Reporting') {
         steps {
            script {
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                ])
            }
         }
      }
   }
}
