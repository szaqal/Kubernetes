# Bootstrapping Kubernetes (Single master)

Last updated on V 1.17

## Bootstrap


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
kubectl apply -f https://docs.projectcalico.org/v3.8/manifests/calico.yaml
```

### Joining Worker

```
kubeadm join 192.168.2.150:6443 --token ir0x2c.3ffnm4vhtncmhok4 --discovery-token-ca-cert-hash sha256:01317ade682d8a8f15913d25ebfc2e104e0cbc0b232dc42ec499e7be07e53a30                                                                        
```


### Dashboard

```
kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0-beta8/aio/deploy/recommended.yaml
kubectl -n kube-system edit service kubernetes-dashboard
```

```
---
apiVersion: v1
kind: ServiceAccount
metadata:
  name: admin-user
  namespace: kubernetes-dashboard
---
apiVersion: rbac.authorization.k8s.io/v1
kind: ClusterRoleBinding
metadata:
  name: admin-user
roleRef:
  apiGroup: rbac.authorization.k8s.io
  kind: ClusterRole
  name: cluster-admin
subjects:
- kind: ServiceAccount
  name: admin-user
  namespace: kubernetes-dashboard

```
