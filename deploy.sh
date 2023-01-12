docker login ghcr.io --username jacekrg --password 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
docker image pull ghcr.io/stormitpl/ideas

docker container stop ideaspro

docker container rm ideaspro

docker run -d --name ideaspro --net=host ghcr.io/jacekrg/ideaspro
