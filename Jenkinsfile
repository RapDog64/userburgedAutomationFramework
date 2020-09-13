pipeline {

    agent any

    tools {
        maven 'Maven 3.6.3'
        jdk 'java 1.8'

    }

    parameters {
        choice(name:'browser', choices:['chrome','firefox'], description:'Select a browser')
        choice(name:'environment', choices:['dev','test'], description:'Select an environment')
        choice(name:'suite', choices:['smoke','regression'], description:'Select a suite')
    }

    stages  {
        stage('Test') {
            steps {
                sh "mvn clean test " +
                 "-Dsurefire.suiteXmlFiles=src/test/resources/suites/${params.suite}.xml" +
                 "-Denvironment=${params.environment}" +
                 "-Dbrowser=${params.browser}"
            }
        }
    }
}