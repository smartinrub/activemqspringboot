# activemqspringboot

## ActiveMQ Docker container

```sh
docker run --name='activemq' -it --rm -e 'ACTIVEMQ_CONFIG_MINMEMORY=512' -e 'ACTIVEMQ_CONFIG_MAXMEMORY=2048' -P -p 8161:8161 -p 61616:61616 -p 61613:61613  webcenter/activemq:latest
```

Open in browser localhost:8161
