# SinkClientLibrarySample
Subscribe to a CCTV Feed (without embedded RTSP server)

## Sample 1: Run Sink Cascade (Consuming from Solace Directly)
The Video Sink Client subscribes video channel and stream it as messaging from Solace broker directly. Users can consume the video data by connecting the Solace and handle it by own application.

### Run
mvn spring-boot:run