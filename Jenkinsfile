post {
        success {
            emailext(
                to: 'Sakina.Baranwala@iiitb.ac.in',  // Add your email here
                subject: 'Build Successful: $JOB_NAME - $BUILD_NUMBER',
                body: "The build was successful.\n\nCheck the build details at: $BUILD_URL"
            )
        }
        failure {
            emailext(
                to: 'Sakina.Baranwala@iiitb.ac.in',  // Add your email here
                subject: 'Build Failed: $JOB_NAME - $BUILD_NUMBER',
                body: "The build failed.\n\nCheck the build details at: $BUILD_URL"
            )
        }
    }