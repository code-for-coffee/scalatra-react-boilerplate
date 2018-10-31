# Awesome Playground #

## Setup Scala, simple build tool (sbt) & JVM

```sh
brew cask install java8
brew install scala
brew install sbt
```

## Re-build & Run on Save ##

```sh
$ cd awesome-playground
$ sbt
> ~;jetty:stop;jetty:start
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.
