docker build -t order-service:v1 -f Dockerfile ./order-service -q --no-cache &
docker build -t payment-service:v1 -f Dockerfile ./payment-service -q --no-cache &
docker build -t gateway-service:v1 -f Dockerfile ./cloud-gateway -q --no-cache &
docker build -t eureka-server:v1 -f Dockerfile ./service-registry -q --no-cache &
docker build -t config-server:v1 -f Dockerfile ./cloud-config-server -q --no-cache &
