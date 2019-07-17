#mvn clean install

eval $(minikube docker-env)

docker build -t config ./config
kubectl delete -f ./setting/kubernetes/config.yaml
kubectl apply -f ./setting/kubernetes/config.yaml

echo "Waiting for starting servies...."
sleep 10s

docker build -t eureka ./eureka
kubectl delete -f ./setting/kubernetes/eureka.yaml
kubectl apply -f ./setting/kubernetes/eureka.yaml
