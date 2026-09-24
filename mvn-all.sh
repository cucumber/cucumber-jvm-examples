#!/bin/bash

set -e

PROJECTS=$(find . -name pom.xml)
for project in $PROJECTS; do
  mvn --file "$project" "$@"
done