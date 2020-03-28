job('First-DSL-job'){
  description("Create a first DSL job to run inside jenkins on ${new Date()}")
  scm{
    git("https://github.com/mahmoudwaf/dsl-job.git",'master')
  }

  triggers {
    scm('* * * * *')
  }
  steps{
    maven('clean package','dsl-job/pom.xml')
  }
  publishers{
    archiveArtifacts '**/*.jar'
  }
}