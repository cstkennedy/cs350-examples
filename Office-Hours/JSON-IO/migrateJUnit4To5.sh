#! /usr/bin/env bash

find -name \*.java | xargs -I "{}" sed -i.bak 's|org.junit.Test|org.junit.jupiter.api.Test|g' "{}"
find -name \*.java | xargs -I "{}" sed -i.bak 's|org.junit.Assert.|org.junit.jupiter.api.Assertions.|g' "{}"
find -name \*.java | xargs -I "{}" sed -i.bak 's|org.junit.FixMethodOrder|org.junit.jupiter.api.TestMethodOrder|g' "{}"
find -name \*.java | xargs -I "{}" sed -i.bak 's|org.junit.runners.MethodSorters|org.junit.jupiter.api.MethodOrderer|g' "{}";  find -name \*.java | xargs -I "{}" sed -i.bak 's|org.junit.Before|org.junit.jupiter.api.BeforeEach|g' "{}"
find -name \*.java | xargs -I "{}" sed -i.bak 's|org.hamcrest.CoreMatchers.|org.hamcrest.Matchers.|g' "{}"
find -name \*.java | xargs -I "{}" sed -i.bak 's|FixMethodOrder(MethodSorters.NAME_ASCENDING)|TestMethodOrder(MethodOrderer.MethodName.class)|g' "{}"
find -name \*.java | xargs -I "{}" sed -i.bak 's|@Before$|@BeforeEach|g' "{}"
find -name \*.java | xargs -I "{}" sed -i.bak 's|import static org.hamcrest.Matchers.*;|import static org.hamcrest.MatcherAssert.assertThat;\nimport static org.hamcrest.Matchers.*;|' "{}"