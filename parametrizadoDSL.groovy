job('ejemplo-2-jod-DSL') {
  description('Job DSL de ejemplopara el curso de Jenkins')
  scm {
    git('git@github.com:juancrespo25/jenkins.job.parametrizado.git', 'main') { node ->
      node / gitConfigName('juancrespo25')
      node / gitConfigEmail('jcrespovirhuez@gmail.com')
    }
  }
  parameters{
    stringParam('nombre', defaultValue = 'Juan', description = 'Parametro de cadena para el Job Boleano')
    choiceParam('planeta', ['Mercurio', 'Venus', 'Tierras', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
    booleanParam('agente', false)
  }
  triggers{
    cron('H/7 * * * *')
  }
  steps {
  	shell("bash jobscript.sh")
  }
  publishers{
  	slackNotifier {
        notifyAborted(true)
        notifyEveryFailure(true)
      	notifyNotBuilt(false)
      	notifyUnstable(false)
      	notifyBackToNormal(true)
        notifySuccess(false)
      	notifyRepeatedFailure(false)
      	startNotification(false)
      	includeTestSummary(false)
      	includeCustomMessage(false)
      	customMessage(null)
      	sendAs(null)
      	commitInfoChoice('NONE')
      	teamDomain(null)
      	authToken(null)
    }
  }
}
