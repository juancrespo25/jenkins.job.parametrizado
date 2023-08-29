#!/bin/bash
echo "Bienvenido al planeta $planeta"
if [ "$agente" == true ]
then
	echo "Preparece para la mision agente X, que la fuerza te acompañe"
else
	echo "Disfruta el planeta humano $nombre, trata de no morir."
fi
echo "..."
sleep 10
echo "!Suerte! La necesitaras!"
