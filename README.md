4. README.md (Basic usage instructions)
# BteaviPredictor

This is a simple genetic prediction app built with Flask and Docker.

## Build and Run Locally with Docker

1. Build the Docker image:

```bash
docker build -t bteavipredictor:local .
Run the Docker container:
docker run -p 8080:8080 -e PORT=8080 bteavipredictor:local
Test the prediction endpoint:
Send a POST request to http://localhost:8080/predict with JSON body:

{
  "markers": {
    "marker1": true,
    "marker2": false,
    "marker3": true
  }
}
You should get a response like:

{
  "trait_present": true,
  "probability": 0.7,
  "score": 0.7
}# Bteavipredictor
A prediction application 
