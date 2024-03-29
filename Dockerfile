FROM maven:3.3.9-jdk-7
MAINTAINER Dario Valocchi <d.valocchi@ucl.ac.uk>

RUN apt-get update && apt-get install -y python-pip \
  python-dev \
  build-essential \
  libcurl4-gnutls-dev \
  librtmp-dev \
  python-setuptools \
  python-httplib2 \
  netcat

RUN pip install --upgrade pip; \
  pip install --upgrade virtualenv; \
  pip install python-keystoneclient; \
  pip install python-heatclient \
  && rm -rf /var/lib/apt/lists/*

ADD adaptor /adaptor
ADD broker.config /etc/son-mano/broker.config
ADD son-sp-infra-* /usr/local/bin/
ADD son-sp-infra /etc/init.d/
COPY ./docker-entrypoint.sh /
RUN chmod +x /usr/local/bin/son-sp-infra-*
RUN chmod +x /etc/init.d/son-sp-infra

WORKDIR /adaptor
RUN mvn clean assembly:single;

ENV broker_host broker
ENV broker_port 5672
ENV broker_exchange son-kernel
ENV broker_uri amqp://guest:guest@broker:5672/%2F

RUN mvn compile assembly:single;

CMD ["/docker-entrypoint.sh"]

