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
```

```
root@kub-master:/home/malczyk# helm install istio istio.io/istio --namespace istio-system
```

```
root@kub-master:/home/malczyk# helm ls -n "istio-system"
NAME                 	NAMESPACE   	REVISION	UPDATED                                	STATUS  	CHART           	APP VERSION
istio                	istio-system	1       	2019-12-23 12:12:46.084614292 +0000 UTC	deployed	istio-1.4.2     	1.4.2
istio-init-1577103019	istio-system	1       	2019-12-23 12:10:19.799815946 +0000 UTC	deployed	istio-init-1.4.2	1.4.2
root@kub-master:/home/malczyk#
```
