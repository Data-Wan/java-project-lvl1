install:
	./gradlew clean install


run-dist:
	./app/build/install/app/bin/app


check-updates:
	./gradlew dependencyUpdates

run:
	./gradlew run

lint:
	./gradlew checkstyleMain

build:
	./gradlew clean build

clean:
	./gradlew clean

.PHONY: run check-updates run-dist install lint build
