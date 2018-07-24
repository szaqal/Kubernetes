# Kubernetes Notes

## Tooling 

[HELM](HELM.md)

#### Froce pod removal

```
kubectl delete pod foo --grace-period=0 --force
```
