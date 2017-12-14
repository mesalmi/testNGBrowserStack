# testNGBrowserStack

_________________
Jenkins Setup:
- Create a Jenkins Maven job
- Define path for Root POM. Example : /Users/MyUser/browserstacktestng/pom.xml
- Define any goal from POM. Example : test -P win81F -Dbrowserstack.automate.debug=true --debug
- Choose Embed BrowserStack Report under Post-Build Actions
