package ru.tinkoff.fintech.homework.hotel.room.service

import org.springframework.stereotype.Service
import ru.tinkoff.fintech.homework.hotel.room.service.client.DevRoomDao
import ru.tinkoff.fintech.homework.hotel.common.model.Room
import ru.tinkoff.fintech.homework.hotel.common.model.Status
import ru.tinkoff.fintech.homework.hotel.room.service.client.RoomDao

@Service
class RoomService(private val roomDao: RoomDao) {
    fun getRoomsByType(type: String): Set<Room> =
        roomDao.getRoomsByType(type)


    fun getRoom(number: Int): Room {
        val result = roomDao.getRoom(number)
        requireNotNull(result) { "Room $number doesn't exists" }
        return result
    }

    fun changeStatus(number: Int, status: Status) {
        try {roomDao.changeStatus(number, status) } catch (e: Exception) {null}
    }
}