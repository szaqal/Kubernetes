# Istio

Add repo

```
helm repo add istio.io https://storage.googleapis.com/istio-release/releases/1.4.2/charts/
```

Create namesapce

```
kubectl create namespace istio-system
```


```
root@kub-master:/home/malczyk# helm install --generate-name istio.io/istio-init --namespace istio-system
NAME: istio-init-1577103019
LAST DEPLOYED: Mon Dec 23 12:10:19 2019
NAMESPACE: istio-system
STATUS: deployed
REVISION: 1
TEST SUITE: None
```

```
root@kub-master:/home/malczyk# helm install istio istio.io/istio --namespace istio-system

NAME: istio
LAST DEPLOYED: Mon Dec 23 12:12:46 2019
NAMESPACE: istio-system
STATUS: deployed
REVISION: 1
TEST SUITE: None
NOTES:
Thank you for installing Istio.

Your release is named Istio.

To get started running application with Istio, execute the following steps:
1. Label namespace that application object will be deployed to by the following command (take default namespace as an example)

$ kubectl label namespace default istio-injection=enabled
$ kubectl get namespace -L istio-injection

2. Deploy your applications

$ kubectl apply -f <your-application>.yaml

For more information on running Istio, visit:
https://istio.io/
```
