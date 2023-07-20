# Google_Dataproc_serverless_scala_job

## sbt install details

website: https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Linux.html

--Java 8 <br>
sudo apt-get update <br>
sudo apt-get install openjdk-8-jdk <br>
<br>
--sbt from the sbt website <br>
sudo apt-get update <br>
sudo apt-get install apt-transport-https curl gnupg -yqq <br>
echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | sudo tee /etc/apt/sources.list.d/sbt.list <br>
echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | sudo tee /etc/apt/sources.list.d/sbt_old.list <br>
<br>
curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo -H gpg --no-default-keyring --keyring gnupg-ring:/etc/apt/trusted.gpg.d/scalasbt-release.gpg --import <br>
sudo chmod 644 /etc/apt/trusted.gpg.d/scalasbt-release.gpg <br>
sudo apt-get update <br>
sudo apt-get install sbt <br>
