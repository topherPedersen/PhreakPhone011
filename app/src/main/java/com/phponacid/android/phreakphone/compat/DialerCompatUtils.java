package com.phponacid.android.phreakphone.compat;

import com.phponacid.android.phreakphone.common.compat.CompatUtils;

/**
 * Created by dang on 2/10/17.
 */

public final class DialerCompatUtils {
    /**
     * Determines if this version has access to the
     * {@link android.provider.CallLog.Calls.CACHED_PHOTO_URI} column
     *
     * @return {@code true} if {@link android.provider.CallLog.Calls.CACHED_PHOTO_URI} is available,
     * {@code false} otherwise
     */
    public static boolean isCallsCachedPhotoUriCompatible() {
        return CompatUtils.isMarshmallowCompatible();
    }
}
