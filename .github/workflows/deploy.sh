docker login ghcr.io --username steiner@10g.pl --password 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
docker image pull ghcr.io/jacekrg/ideaspro

docker container stop ideaspro

docker container rm ideaspro

docker run -d --name ideaspro --net=host ghcr.io/jacekrg/ideaspro
