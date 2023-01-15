
docker login ghcr.io --username jacekrg --password-stdin ${{ secrets.GH_TOKEN }}
docker image pull ghcr.io/jacekrg/ideaspro

docker container stop ideaspro

docker container rm ideaspro

docker run -d --name ideaspro --net=host ghcr.io/jacekrg/ideaspro
