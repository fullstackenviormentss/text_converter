/*
 * Copyright (c) 2017 by Tran Le Duy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duy.text.converter.core.codec;

import android.content.Context;
import android.support.annotation.NonNull;

import com.duy.text.converter.core.codec.interfaces.CodecImpl;

import org.apache.commons.codec.binary.Base32;

/**
 * Created by Duy on 11-Jul-17.
 */

public class Base32Codec extends CodecImpl {
    private Base32 base32 = new Base32();

    @NonNull
    @Override
    public String encode(@NonNull String text) {
        setMax(1);
        try {
            String result = new String(base32.encode(text.getBytes()));
            setConfident(1);
            return result;
        } catch (Exception e) {
            setConfident(0);
            return text;
        }
    }

    @NonNull
    @Override
    public String decode(@NonNull String text) {
        setMax(1);
        try {
            setConfident(1);
            return new String(base32.decode(text.getBytes()));
        } catch (Exception e) {
            setConfident(0);
            return text;
        }
    }

    @NonNull
    @Override
    public String getName(Context context) {
        return "Base 32";
    }
}
