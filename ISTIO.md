# Istio

## With HELM (deprecated)

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

## With ISTIOCTL

Pull and extract 

```
curl -L https://istio.io/downloadIstio | sh -
```

Initilize
```
istioctl manifest apply 
```

Istio Injection
```
root@kub-master:/home/malczyk/k8# kubectl label namespace default istio-injection=enabled
namespace/default labeled
root@kub-master:/home/malczyk/k8# kubectl get namespace -L istio-injection
NAME              STATUS   AGE     ISTIO-INJECTION
default           Active   6d19h   enabled
istio-system      Active   2d16h   disabled
```

* Prometheus dashboard ```istioctl  dashboard prometheus prometheus-66c5887c86-dfq5g```


### Testing

```
root@kub-master:/home/malczyk/DummyApps/dummy-http/istio# kubectl get namespace -L istio-injection
NAME              STATUS   AGE     ISTIO-INJECTION
default           Active   6d20h   enabled

root@kub-master:/home/malczyk/DummyApps/dummy-http/istio# kubectl create -f deployment.yml
root@kub-master:/home/malczyk/DummyApps/dummy-http/istio# kubectl get pods
NAME                         READY   STATUS    RESTARTS   AGE
dummy-http-d6bc685d7-wkpc5   2/2     Running   0          16s

root@kub-master:/home/malczyk/DummyApps/dummy-http/istio# kubectl create -f istio-gw.yml
root@kub-master:/home/malczyk/DummyApps/dummy-http/istio# kubectl create -f istio-vs.yml

root@kub-master:/home/malczyk/DummyApps/dummy-http/istio# kubectl get virtualservices --all-namespaces
NAMESPACE   NAME         GATEWAYS               HOSTS   AGE
default     dummy-http   [dummy-http-gateway]   [*]     7s

root@kub-master:/home/malczyk/DummyApps/dummy-http/istio# curl  localhost:30613
{"time":"2019-12-30T07:31:20Z"}

root@kub-master:/home/malczyk/DummyApps/dummy-http/istio# istioctl proxy-status
NAME                                                   CDS        LDS        EDS        RDS        PILOT                          VERSION
dummy-http-d6bc685d7-wkpc5.default                     SYNCED     SYNCED     SYNCED     SYNCED     istio-pilot-d4fd9c9f-x68ch     1.4.2

root@kub-master:/home/malczyk/DummyApps/dummy-http/istio# istioctl proxy-config route dummy-http-d6bc685d7-wkpc5.default
NOTE: This output only contains routes loaded via RDS.
NAME                                                          VIRTUAL HOSTS
dummy-http.default.svc.cluster.local:80                       1
```

[prom](img/prom.png)
