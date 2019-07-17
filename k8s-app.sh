#mvn clean install

eval $(minikube docker-env)

docker build -t msf-employee ./employee
kubectl delete -f ./setting/kubernetes/employee.yaml
kubectl apply -f ./setting/kubernetes/employee.yaml

echo "Waiting for starting servies...."
sleep 10s

docker build -t apigateway ./apigateway
kubectl delete -f ./setting/kubernetes/apigateway.yaml
kubectl apply -f ./setting/kubernetes/apigateway.yaml

echo "Waiting for starting servies...."
sleep 10s

kubectl delete -f ./setting/kubernetes/api-ingress.yaml
kubectl apply -f ./setting/kubernetes/api-ingress.yaml
kubectl describe ing gateway-ingress
