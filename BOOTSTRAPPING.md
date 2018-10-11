# Bootstrapping Kubernetes (Single master)

* Bootstrap

```
kubeadm init --pod-network-cidr 10.24.0.0/16
```

* Kubectl setup

```
mkdir -p $HOME/.kube
sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
sudo chown $(id -u):$(id -g) $HOME/.kube/config
```

* Networking setup

```
kubectl apply -f https://docs.projectcalico.org/v3.1/getting-started/kubernetes/installation/hosted/rbac-kdd.yaml
kubectl apply -f https://docs.projectcalico.org/v3.1/getting-started/kubernetes/installation/hosted/kubernetes-datastore/calico-networking/1.7/calico.yaml
```

### Joining Worker

```
kubeadm join 192.168.2.150:6443 --token ir0x2c.3ffnm4vhtncmhok4 --discovery-token-ca-cert-hash sha256:01317ade682d8a8f15913d25ebfc2e104e0cbc0b232dc42ec499e7be07e53a30                                                                        
```


### Dashboard

```
kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/master/src/deploy/recommended/kubernetes-dashboard.yaml
kubectl -n kube-system edit service kubernetes-dashboard
```


### Cheetsheet

```
kubectl get all --all-namespaces
```
