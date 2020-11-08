/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.delaroystudios.roomcontentprovider.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;


/**
 * Data access object for Menu.
 */
@Dao
public interface MenuDao {

    @Query("SELECT COUNT(*) FROM " + Menu.TABLE_NAME)
    int count();

    @Insert
    long insert(Menu menu);

    @Insert
    long[] insertAll(Menu[] menus);

    @Query("SELECT * FROM " + Menu.TABLE_NAME)
    Cursor selectAll();

    @Query("SELECT * FROM " + Menu.TABLE_NAME + " WHERE " + Menu.COLUMN_ID + " = :id")
    Cursor selectById(long id);

    @Query("DELETE FROM " + Menu.TABLE_NAME + " WHERE " + Menu.COLUMN_ID + " = :id")
    int deleteById(long id);

    @Update
    int update(Menu menu);

}
