# Istio

## HELM

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

## ISTIOCTL

```
curl -L https://istio.io/downloadIstio | sh -
```

```
istioctl manifest apply 
```


* Prometheus dashboard ```istioctl  dashboard prometheus prometheus-66c5887c86-dfq5g```

```
malczyk@kub-master:~$ istioctl proxy-config route memcached-596696cc9b-mfnh8.default
NOTE: This output only contains routes loaded via RDS.
NAME                                                                      VIRTUAL HOSTS
80                                                                        2
8060                                                                      2
8080                                                                      2
9090                                                                      2
9091                                                                      3
9901                                                                      2
15004                                                                     3
15010                                                                     2
istio-ingressgateway.istio-system.svc.cluster.local:15030                 1
istio-ingressgateway.istio-system.svc.cluster.local:15029                 1
memcached.default.svc.cluster.local:11211                                 1
kube-dns.kube-system.svc.cluster.local:9153                               1
istio-telemetry.istio-system.svc.cluster.local:42422                      1
istio-sidecar-injector.istio-system.svc.cluster.local:443                 1
istio-ingressgateway.istio-system.svc.cluster.local:15031                 1
kubernetes-dashboard.kubernetes-dashboard.svc.cluster.local:443           1
istio-ingressgateway.istio-system.svc.cluster.local:15032                 1
istio-ingressgateway.istio-system.svc.cluster.local:15020                 1
dashboard-metrics-scraper.kubernetes-dashboard.svc.cluster.local:8000     1
15014                                                                     6
15019                                                                     2
                                                                          1
```
