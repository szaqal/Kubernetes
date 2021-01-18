# HELM

## Terminology


## Usage

### Looking for charts

```
helm repo update
helm search hub --> Monocular
helm search repo memcached
```

### Install chart

```
helm install --name test-memcached stable/memcached
```

```
root@ion-kubernetes-01:/home/malczyk# helm list
NAME          	REVISION	UPDATED                 	STATUS  	CHART          	NAMESPACE
test-memcached	1       	Wed Jul 25 15:28:52 2018	DEPLOYED	memcached-2.2.0	default  
```

### Others

* ```helm inspect```

## Development

* Create new chart ```helm create test-chart```

* Packaging ```helm package test-chart```

## Build-in Objects

* Relase.[Name|Time|Namespace|Service|Revision]

* Values (values.yml)

* Char (Chart.yml)

## Good practices

* Chart names should use lower case letters and numbers, and start with a letter.


### ISSUES

helm 2.17.0 connection issues required changin pod network CIDR 172.16.0.0/16

and adding

```
kubectl --namespace=kube-system create clusterrolebinding add-on-cluster-admin --clusterrole=cluster-admin --serviceaccount=kube-system:default
```


### Repositories

#### S3

```
helm plugin install https://github.com/hypnoglow/helm-s3.git
```
***This didn't work for me when heml installed through snap***

```
helm s3 init s3://test-helm
Initialized empty repository at s3://test-helm
```

```
helm repo add test-charts s3://test-helm
"test-charts" has been added to your repositories
```


```
helm repo list
```

```
helm s3 push --force ./test-chart-0.1.0.tgz  test-charts
```

* [Google Repo](https://kubernetes-charts.storage.googleapis.com/)
* [Kube Apps](https://hub.kubeapps.com/)
* [Moncular](https://github.com/helm/monocular)
* [ChartMuseum](https://github.com/helm/chartmuseum)
* [Orca](https://github.com/nuvo/orca)
