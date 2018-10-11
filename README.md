# Kubernetes Notes

## Tooling 

[HELM](HELM.md)

[KUBEVIRT](KUBEVIRT.md)

[GLUSTERFS](GLUSTERFS.md)

[MetalLB](METALLB.md)

## Bootstrapping

 [Bootstrapping](BOOTSTRAPPING.md)


## Operations

 [Network Policies](NETPOLICIES.md)

 [Cheetsheet](CHEETSHEET.md)


### Multi interface hosts

Whenever there are mutliple hosts that share the same iterface name and address You may need to set Calico setup ```IP_AUTODETECTION_METHOD``` since conflicts may happen and this can be avoided.

## Random notes

* Stateful sets: each of your pods is guaranteed the same network identity and disk across restarts, even if it's rescheduled to a different physical machine.

* DaemonSets let you specify that a group of nodes should always run a specific pod.

## Projects

* [Telegraf](https://github.com/influxdata/telegraf) [Telegraf on K8S](https://github.com/influxdata/telegraf/tree/master/plugins/inputs/kubernetes)

* [MetalLB](https://github.com/google/metallb)

* [Ballerina](https://ballerina.io/)

* [KubeWatch](https://github.com/bitnami-labs/kubewatch)

* [Fission](https://fission.io/)

* [OpenFAAS](https://github.com/openfaas/faas)

* [OpenEBS](https://docs.openebs.io/docs/next/introduction.html)

* [Kubevirt](https://github.com/kubevirt/kubevirt)

* [cAdvisor](https://github.com/google/cadvisor)
