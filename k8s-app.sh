#mvn clean install

eval $(minikube docker-env)

docker build -t msf-employee ./employee
kubectl delete -f ./setting/kubernetes/employee.yaml
kubectl apply -f ./setting/kubernetes/employee.yaml

echo "Waiting for starting servies...."
sleep 5s

docker build -t apigateway ./apigateway
kubectl delete -f ./setting/kubernetes/apigateway.yaml
kubectl apply -f ./setting/kubernetes/apigateway.yaml

echo "Waiting for starting servies...."
sleep 5s

kubectl delete -f ./setting/kubernetes/api-ingress.yaml
kubectl apply -f ./setting/kubernetes/api-ingress.yaml
kubectl describe ing gateway-ingress

echo "Waiting for starting servies...."
sleep 5s

docker build -t msf-basicexample ./basicexample
kubectl delete -f ./setting/kubernetes/basicexample.yaml
kubectl apply -f ./setting/kubernetes/basicexample.yaml

echo "Waiting for starting servies...."
sleep 5s

docker build -t msf-clientexample ./clientexample
kubectl delete -f ./setting/kubernetes/clientexample.yaml
kubectl apply -f ./setting/kubernetes/clientexample.yaml
