package com.example.pollopollito.data.prefs

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserPrefs(private val context: Context) {

    private val KEY_USER_ID = stringPreferencesKey("user_id")
    private val KEY_INITIALS = stringPreferencesKey("initials")

    val userId: Flow<String?> = context.dataStore.data.map { it[KEY_USER_ID] }
    val initials: Flow<String?> = context.dataStore.data.map { it[KEY_INITIALS] }

    suspend fun loginAsCr() {
        context.dataStore.edit {
            it[KEY_USER_ID] = "CR"
            it[KEY_INITIALS] = "CR"
        }
    }

    suspend fun logout() {
        context.dataStore.edit {
            it.remove(KEY_USER_ID)
            it.remove(KEY_INITIALS)
        }
    }
}
