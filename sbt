java -Drebel.lift_plugin=true -noverify -javaagent:/opt/jrebel/jrebel.jar -Xmx1024M -Xss2M -XX:MaxPermSize=512m -XX:+CMSClassUnloadingEnabled -jar `dirname $0`/sbt-launch-0.12.1.jar "$@"
