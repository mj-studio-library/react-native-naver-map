package com.mjstudio.reactnativenavermap.overlay.circle

import android.graphics.Color
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.uimanager.PixelUtil
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.mjstudio.reactnativenavermap.RNCNaverMapCircleManagerSpec
import com.mjstudio.reactnativenavermap.event.NaverMapOverlayTapEvent
import com.mjstudio.reactnativenavermap.util.getLatLng
import com.mjstudio.reactnativenavermap.util.registerDirectEvent
import com.naver.maps.map.overlay.CircleOverlay


class RNCNaverMapCircleManager : RNCNaverMapCircleManagerSpec<RNCNaverMapCircle>() {
    override fun getName(): String {
        return NAME
    }

    override fun createViewInstance(context: ThemedReactContext): RNCNaverMapCircle {
        return RNCNaverMapCircle(context)
    }

    override fun onDropViewInstance(view: RNCNaverMapCircle) {
        super.onDropViewInstance(view)
        view.onDropViewInstance()
    }

    override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any> =
        (super.getExportedCustomDirectEventTypeConstants() ?: mutableMapOf()).apply {
            registerDirectEvent(this, NaverMapOverlayTapEvent.EVENT_NAME)
        }


    private fun RNCNaverMapCircle?.withOverlay(fn: (CircleOverlay) -> Unit) {
        this?.overlay?.run(fn)
    }

    @ReactProp(name = "position")
    override fun setPosition(view: RNCNaverMapCircle, value: ReadableMap?) = view.withOverlay {
        value.getLatLng()?.run {
            it.center = this
        }
    }

    @ReactProp(name = "zIndexValue")
    override fun setZIndexValue(view: RNCNaverMapCircle?, value: Int) = view.withOverlay {
        it.zIndex = value
    }

    @ReactProp(name = "isHidden")
    override fun setIsHidden(view: RNCNaverMapCircle?, value: Boolean) = view.withOverlay {
        it.isVisible = !value
    }

    @ReactProp(name = "minZoom")
    override fun setMinZoom(view: RNCNaverMapCircle?, value: Double) = view.withOverlay {
        it.minZoom = value
    }

    @ReactProp(name = "maxZoom")
    override fun setMaxZoom(view: RNCNaverMapCircle?, value: Double) = view.withOverlay {
        it.maxZoom = value
    }

    @ReactProp(name = "isMinZoomInclusive")
    override fun setIsMinZoomInclusive(view: RNCNaverMapCircle?, value: Boolean) =
        view.withOverlay {
            it.isMinZoomInclusive = value
        }

    @ReactProp(name = "isMaxZoomInclusive")
    override fun setIsMaxZoomInclusive(view: RNCNaverMapCircle?, value: Boolean) =
        view.withOverlay {
            it.isMaxZoomInclusive = value
        }

    @ReactProp(name = "radius")
    override fun setRadius(view: RNCNaverMapCircle?, value: Double) = view.withOverlay {
        it.radius = value
    }

    @ReactProp(name = "color")
    override fun setColor(view: RNCNaverMapCircle?, value: Int) = view.withOverlay {
        it.color = value
    }

    @ReactProp(name = "outlineWidth")
    override fun setOutlineWidth(view: RNCNaverMapCircle?, value: Double) = view.withOverlay {
        it.outlineWidth = PixelUtil.toPixelFromDIP(value).toInt()
    }

    @ReactProp(name = "outlineColor")
    override fun setOutlineColor(view: RNCNaverMapCircle?, value: Int) = view.withOverlay {
        it.outlineColor = value ?: Color.TRANSPARENT
    }


    // region PROPS

    companion object {
        const val NAME = "RNCNaverMapCircle"
    }
}
