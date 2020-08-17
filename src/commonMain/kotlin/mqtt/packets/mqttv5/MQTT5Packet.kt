package mqtt.packets.mqttv5

import mqtt.packets.MQTTPacket

abstract class MQTT5Packet(private val properties: MQTT5Properties) : MQTTPacket {

    open fun resizeIfTooBig(maximumPacketSize: UInt): Boolean {
        // CONNACK, PUBACK, PUBREC, PUBREL, PUBCOMP, SUBACK, UNSUBACK, DISCONNECT, AUTH
        if (size() > maximumPacketSize) {
            properties.reasonString = null
        }
        if (size() > maximumPacketSize) {
            properties.userProperty.clear()
        }
        return size() <= maximumPacketSize
    }
}
