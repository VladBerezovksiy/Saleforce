pipeline {
    agent any

    environment {
            driver_path = "src/test/resources/linux/chromedriver"
    }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven"
    }

    stages {
        stage('tests') {
            steps {
                git branch: '$BRANCH', url: 'https://github.com/VladBerezovksiy/Saleforce.git'

                sh 'pwd'
                sh 'ls -l'
                sh 'chmod -R 777 $driver_path'
                sh 'ls -l $driver_path'

                // Run Maven on a Unix agent.
                sh "mvn clean test -Dmaven.test.failure.ignore=true -Dmaven.compiler.source=11 -Dmaven.compiler.target=11"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('reports') {
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