# Croaker
[![Build Status](https://travis-ci.org/lapek/croaker.svg?branch=master)](https://travis-ci.org/lapek/croaker)
[![codecov](https://codecov.io/gh/lapek/croaker/branch/master/graph/badge.svg)](https://codecov.io/gh/lapek/croaker)

Twitter-clone project for training purpose (under development).

### Built With
* Spring Boot 2 (based on Spring 5) with Gradle
* ElasticSearch 7.5 
* Angular 6 (with Angular Material) 

### Setting up Dev

To start developing the project:

```shell
git clone https://github.com/lapek/croaker.git
```

Then set <i>cluster.name: croaker-cluster</i> in elasticsearch config file:<br>
<i>/etc/elasticsearch/elasticsearch.yml</i> (Linux)  or  <i>'path-to-es'/config/elasticsearch.yml</i> (Windows)

Test project:
```shell
./gradlew check
```

Start project:
```shell
./gradlew bootRun
```