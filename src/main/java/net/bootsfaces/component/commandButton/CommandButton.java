/**
 *  Copyright 2014 Riccardo Massera (TheCoder4.Eu)
 *  
 *  This file is part of BootsFaces.
 *  
 *  BootsFaces is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  BootsFaces is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with BootsFaces. If not, see <http://www.gnu.org/licenses/>.
 */

package net.bootsfaces.component.commandButton;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UICommand;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;

import net.bootsfaces.C;
import net.bootsfaces.component.ajax.IAJAXComponent;
import net.bootsfaces.listeners.AddResourcesListener;
import net.bootsfaces.render.IHasTooltip;
import net.bootsfaces.render.Tooltip;

/**
 *
 * @author thecoder4.eu
 */

@ResourceDependencies({ @ResourceDependency(library = "bsf", name = "css/core.css", target = "head"),
		@ResourceDependency(library = "javax.faces", name = "jsf.js", target = "head"),
		@ResourceDependency(library = "bsf", name = "js/bsf.js", target = "head"),
		@ResourceDependency(library = "bsf", name = "css/tooltip.css", target = "head") })
@FacesComponent(CommandButton.COMPONENT_TYPE)
public class CommandButton extends UICommand implements ClientBehaviorHolder, IHasTooltip, IAJAXComponent {

	/**
	 * <p>
	 * The standard component type for this component.
	 * </p>
	 */
	public static final String COMPONENT_TYPE = "net.bootsfaces.component.commandButton.CommandButton";
	/**
	 * <p>
	 * The component family for this component.
	 * </p>
	 */
	public static final String COMPONENT_FAMILY = "net.bootsfaces.component";

	/**
	 * <p>
	 * Default renderer.
	 * </p>
	 */
	public static final String DEFAULT_RENDERER = "net.bootsfaces.component.commandButton.CommandButton";

	private static final Collection<String> EVENT_NAMES = Collections
			.unmodifiableCollection(Arrays.asList("blur", "change", "click", "dblclick", "focus", "keydown", "keypress",
					"keyup", "mousedown", "mousemove", "mouseout", "mouseover", "mouseup", "select"));

	public CommandButton() {
		setRendererType(DEFAULT_RENDERER); // this component renders itself
		AddResourcesListener.addResourceToHeadButAfterJQuery(C.BSF_LIBRARY, "jq/jquery.js");
		Tooltip.addResourceFile();
	}

    /**
     * returns the subset of AJAX requests that are implemented by jQuery callback or other non-standard means
     * (such as the onclick event of b:tabView, which has to be implemented manually).
     * @return
     */
    public Map<String, String> getJQueryEvents() {
    	return null;
    }

    public Collection<String> getEventNames() {
		return EVENT_NAMES;
	}

	public String getDefaultEventName() {
		return "click";
	}

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	@Override
	public void decode(FacesContext context) {
		// TODO Auto-generated method stub
		super.decode(context);
	}

	protected enum PropertyKeys {
		accesskey, ajax, binding, dir, disabled, icon, iconAlign, iconAwesome, immediate, lang, look, onblur, onchange, onclick, oncomplete, ondblclick, onfocus, onkeydown, onkeypress, onkeyup, onmousedown, onmousemove, onmouseout, onmouseover, onmouseup, onselect, process, size, style, styleClass, tabindex, title, tooltip, tooltipDelay, tooltipDelayHide, tooltipDelayShow, tooltipPosition, type, update, value, tooltipContainer;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {
		}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
		}
	}

	/**
	 * Where is the tooltip div generated? That's primarily a technical value that can be used to fix rendering error in special cases. Also see data-container in the documentation of Bootstrap. The default value is body. <P>
	 * @return Returns the value of the attribute, or null, if it hasn't been set by the JSF file.
	 */
	public String getTooltipContainer() {
		String value = (String)getStateHelper().eval(PropertyKeys.tooltipContainer, "body");
		return  value;
	}
	
	/**
	 * Where is the tooltip div generated? That's primarily a technical value that can be used to fix rendering error in special cases. Also see data-container in the documentation of Bootstrap. The default value is body. <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setTooltipContainer(String _tooltipContainer) {
	    getStateHelper().put(PropertyKeys.tooltipContainer, _tooltipContainer);
    }
	/**
	 * Comma or space separated list of ids or search expressions denoting which values are to be sent to the server. <P>
	 * @return Returns the value of the attribute, or null, if it hasn't been set by the JSF file.
	 */
	public String getProcess() {
		String value = (String)getStateHelper().eval(PropertyKeys.process);
		return  value;
	}
	
	/**
	 * Comma or space separated list of ids or search expressions denoting which values are to be sent to the server. <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setProcess(String _process) {
	    getStateHelper().put(PropertyKeys.process, _process);
    }

	/**
	 * Access key to transfer focus to the input element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getAccesskey() {
		String value = (String) getStateHelper().eval(PropertyKeys.accesskey);
		return value;
	}

	/**
	 * Access key to transfer focus to the input element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setAccesskey(String _accesskey) {
		getStateHelper().put(PropertyKeys.accesskey, _accesskey);
	}

	/**
	 * Whether the Button submits the form with AJAX.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public boolean isAjax() {
		Boolean value = (Boolean) getStateHelper().eval(PropertyKeys.ajax, false);
		return (boolean) value;
	}

	/**
	 * Whether the Button submits the form with AJAX.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setAjax(boolean _ajax) {
		getStateHelper().put(PropertyKeys.ajax, _ajax);
	}

	/**
	 * An el expression referring to a server side UIComponent instance in a
	 * backing bean.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public javax.faces.component.UIComponent getBinding() {
		javax.faces.component.UIComponent value = (javax.faces.component.UIComponent) getStateHelper()
				.eval(PropertyKeys.binding);
		return value;
	}

	/**
	 * An el expression referring to a server side UIComponent instance in a
	 * backing bean.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setBinding(javax.faces.component.UIComponent _binding) {
		getStateHelper().put(PropertyKeys.binding, _binding);
	}

	/**
	 * Direction indication for text that does not inherit directionality.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getDir() {
		String value = (String) getStateHelper().eval(PropertyKeys.dir);
		return value;
	}

	/**
	 * Direction indication for text that does not inherit directionality.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setDir(String _dir) {
		getStateHelper().put(PropertyKeys.dir, _dir);
	}

	/**
	 * Boolean value to specify if the button is disabled.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public boolean isDisabled() {
		Boolean value = (Boolean) getStateHelper().eval(PropertyKeys.disabled, false);
		return (boolean) value;
	}

	/**
	 * Boolean value to specify if the button is disabled.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setDisabled(boolean _disabled) {
		getStateHelper().put(PropertyKeys.disabled, _disabled);
	}

	/**
	 * Button Icon, can be one of the Bootstrap icon names. Alignment can be
	 * specified with iconAlign attribute.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getIcon() {
		String value = (String) getStateHelper().eval(PropertyKeys.icon);
		return value;
	}

	/**
	 * Button Icon, can be one of the Bootstrap icon names. Alignment can be
	 * specified with iconAlign attribute.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setIcon(String _icon) {
		getStateHelper().put(PropertyKeys.icon, _icon);
	}

	/**
	 * Alignment can right or left.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getIconAlign() {
		String value = (String) getStateHelper().eval(PropertyKeys.iconAlign);
		return value;
	}

	/**
	 * Alignment can right or left.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setIconAlign(String _iconAlign) {
		getStateHelper().put(PropertyKeys.iconAlign, _iconAlign);
	}

	/**
	 * Font Awesome Icon to show in this CommandButton, can be one of the Font
	 * Awesome icon names. Alignment can be specified with the iconAlign
	 * attribute.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getIconAwesome() {
		String value = (String) getStateHelper().eval(PropertyKeys.iconAwesome);
		return value;
	}

	/**
	 * Font Awesome Icon to show in this CommandButton, can be one of the Font
	 * Awesome icon names. Alignment can be specified with the iconAlign
	 * attribute.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setIconAwesome(String _iconAwesome) {
		getStateHelper().put(PropertyKeys.iconAwesome, _iconAwesome);
	}

	/**
	 * Flag indicating that, if this component is activated by the user,
	 * notifications should be delivered to interested listeners and actions
	 * immediately (that is, during Apply Request Values phase) rather than
	 * waiting until Invoke Application phase. Default is false.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public boolean isImmediate() {
		Boolean value = (Boolean) getStateHelper().eval(PropertyKeys.immediate, false);
		return (boolean) value;
	}

	/**
	 * Flag indicating that, if this component is activated by the user,
	 * notifications should be delivered to interested listeners and actions
	 * immediately (that is, during Apply Request Values phase) rather than
	 * waiting until Invoke Application phase. Default is false.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setImmediate(boolean _immediate) {
		getStateHelper().put(PropertyKeys.immediate, _immediate);
	}

	/**
	 * A localized user presentable name.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getLang() {
		String value = (String) getStateHelper().eval(PropertyKeys.lang);
		return value;
	}

	/**
	 * A localized user presentable name.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setLang(String _lang) {
		getStateHelper().put(PropertyKeys.lang, _lang);
	}

	/**
	 * Look of the Button, can be primary, block, info, success, warning,
	 * important, danger. If not specified, Standard gray button with gradient
	 * is rendered.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getLook() {
		String value = (String) getStateHelper().eval(PropertyKeys.look);
		return value;
	}

	/**
	 * Look of the Button, can be primary, block, info, success, warning,
	 * important, danger. If not specified, Standard gray button with gradient
	 * is rendered.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setLook(String _look) {
		getStateHelper().put(PropertyKeys.look, _look);
	}

	/**
	 * Client side callback to execute when input element loses focus.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getOnblur() {
		String value = (String) getStateHelper().eval(PropertyKeys.onblur);
		return value;
	}

	/**
	 * Client side callback to execute when input element loses focus.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setOnblur(String _onblur) {
		getStateHelper().put(PropertyKeys.onblur, _onblur);
	}

	/**
	 * Client side callback to execute when input element loses focus and its
	 * value has been modified since gaining focus.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getOnchange() {
		String value = (String) getStateHelper().eval(PropertyKeys.onchange);
		return value;
	}

	/**
	 * Client side callback to execute when input element loses focus and its
	 * value has been modified since gaining focus.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setOnchange(String _onchange) {
		getStateHelper().put(PropertyKeys.onchange, _onchange);
	}

	/**
	 * The onclick attribute.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getOnclick() {
		String value = (String) getStateHelper().eval(PropertyKeys.onclick);
		return value;
	}

	/**
	 * The onclick attribute.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setOnclick(String _onclick) {
		getStateHelper().put(PropertyKeys.onclick, _onclick);
	}

	/**
	 * Javascript to be executed when ajax completes with success.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getOncomplete() {
		String value = (String) getStateHelper().eval(PropertyKeys.oncomplete);
		return value;
	}

	/**
	 * Javascript to be executed when ajax completes with success.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setOncomplete(String _oncomplete) {
		getStateHelper().put(PropertyKeys.oncomplete, _oncomplete);
	}

	/**
	 * Client side callback to execute when input element is double clicked.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getOndblclick() {
		String value = (String) getStateHelper().eval(PropertyKeys.ondblclick);
		return value;
	}

	/**
	 * Client side callback to execute when input element is double clicked.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setOndblclick(String _ondblclick) {
		getStateHelper().put(PropertyKeys.ondblclick, _ondblclick);
	}

	/**
	 * Client side callback to execute when input element receives focus.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getOnfocus() {
		String value = (String) getStateHelper().eval(PropertyKeys.onfocus);
		return value;
	}

	/**
	 * Client side callback to execute when input element receives focus.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setOnfocus(String _onfocus) {
		getStateHelper().put(PropertyKeys.onfocus, _onfocus);
	}

	/**
	 * Client side callback to execute when a key is pressed down over input
	 * element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getOnkeydown() {
		String value = (String) getStateHelper().eval(PropertyKeys.onkeydown);
		return value;
	}

	/**
	 * Client side callback to execute when a key is pressed down over input
	 * element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setOnkeydown(String _onkeydown) {
		getStateHelper().put(PropertyKeys.onkeydown, _onkeydown);
	}

	/**
	 * Client side callback to execute when a key is pressed and released over
	 * input element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getOnkeypress() {
		String value = (String) getStateHelper().eval(PropertyKeys.onkeypress);
		return value;
	}

	/**
	 * Client side callback to execute when a key is pressed and released over
	 * input element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setOnkeypress(String _onkeypress) {
		getStateHelper().put(PropertyKeys.onkeypress, _onkeypress);
	}

	/**
	 * Client side callback to execute when a key is released over input
	 * element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getOnkeyup() {
		String value = (String) getStateHelper().eval(PropertyKeys.onkeyup);
		return value;
	}

	/**
	 * Client side callback to execute when a key is released over input
	 * element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setOnkeyup(String _onkeyup) {
		getStateHelper().put(PropertyKeys.onkeyup, _onkeyup);
	}

	/**
	 * Client side callback to execute when a pointer input element is pressed
	 * down over input element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getOnmousedown() {
		String value = (String) getStateHelper().eval(PropertyKeys.onmousedown);
		return value;
	}

	/**
	 * Client side callback to execute when a pointer input element is pressed
	 * down over input element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setOnmousedown(String _onmousedown) {
		getStateHelper().put(PropertyKeys.onmousedown, _onmousedown);
	}

	/**
	 * Client side callback to execute when a pointer input element is moved
	 * within input element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getOnmousemove() {
		String value = (String) getStateHelper().eval(PropertyKeys.onmousemove);
		return value;
	}

	/**
	 * Client side callback to execute when a pointer input element is moved
	 * within input element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setOnmousemove(String _onmousemove) {
		getStateHelper().put(PropertyKeys.onmousemove, _onmousemove);
	}

	/**
	 * Client side callback to execute when a pointer input element is moved
	 * away from input element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getOnmouseout() {
		String value = (String) getStateHelper().eval(PropertyKeys.onmouseout);
		return value;
	}

	/**
	 * Client side callback to execute when a pointer input element is moved
	 * away from input element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setOnmouseout(String _onmouseout) {
		getStateHelper().put(PropertyKeys.onmouseout, _onmouseout);
	}

	/**
	 * Client side callback to execute when a pointer input element is moved
	 * onto input element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getOnmouseover() {
		String value = (String) getStateHelper().eval(PropertyKeys.onmouseover);
		return value;
	}

	/**
	 * Client side callback to execute when a pointer input element is moved
	 * onto input element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setOnmouseover(String _onmouseover) {
		getStateHelper().put(PropertyKeys.onmouseover, _onmouseover);
	}

	/**
	 * Client side callback to execute when a pointer input element is released
	 * over input element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getOnmouseup() {
		String value = (String) getStateHelper().eval(PropertyKeys.onmouseup);
		return value;
	}

	/**
	 * Client side callback to execute when a pointer input element is released
	 * over input element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setOnmouseup(String _onmouseup) {
		getStateHelper().put(PropertyKeys.onmouseup, _onmouseup);
	}

	/**
	 * Client side callback to execute when text within input element is
	 * selected by user.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getOnselect() {
		String value = (String) getStateHelper().eval(PropertyKeys.onselect);
		return value;
	}

	/**
	 * Client side callback to execute when text within input element is
	 * selected by user.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setOnselect(String _onselect) {
		getStateHelper().put(PropertyKeys.onselect, _onselect);
	}

	/**
	 * Size of the Button, can be large, small, mini. If not specified, Standard
	 * size button is rendered.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getSize() {
		String value = (String) getStateHelper().eval(PropertyKeys.size);
		return value;
	}

	/**
	 * Size of the Button, can be large, small, mini. If not specified, Standard
	 * size button is rendered.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setSize(String _size) {
		getStateHelper().put(PropertyKeys.size, _size);
	}

	/**
	 * Inline style of the input element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getStyle() {
		String value = (String) getStateHelper().eval(PropertyKeys.style);
		return value;
	}

	/**
	 * Inline style of the input element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setStyle(String _style) {
		getStateHelper().put(PropertyKeys.style, _style);
	}

	/**
	 * Style class of this element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getStyleClass() {
		String value = (String) getStateHelper().eval(PropertyKeys.styleClass);
		return value;
	}

	/**
	 * Style class of this element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setStyleClass(String _styleClass) {
		getStateHelper().put(PropertyKeys.styleClass, _styleClass);
	}

	/**
	 * Advisory tooltip information.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getTabindex() {
		String value = (String) getStateHelper().eval(PropertyKeys.tabindex);
		return value;
	}

	/**
	 * Advisory tooltip information.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setTabindex(String _tabindex) {
		getStateHelper().put(PropertyKeys.tabindex, _tabindex);
	}

	/**
	 * Advisory tooltip information.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getTitle() {
		String value = (String) getStateHelper().eval(PropertyKeys.title);
		return value;
	}

	/**
	 * Advisory tooltip information.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setTitle(String _title) {
		getStateHelper().put(PropertyKeys.title, _title);
	}

	/**
	 * The text of the tooltip.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getTooltip() {
		String value = (String) getStateHelper().eval(PropertyKeys.tooltip);
		return value;
	}

	/**
	 * The text of the tooltip.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setTooltip(String _tooltip) {
		getStateHelper().put(PropertyKeys.tooltip, _tooltip);
	}

	/**
	 * The tooltip is shown and hidden with a delay. This value is the delay in
	 * milliseconds. Defaults to 0 (no delay).
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public int getTooltipDelay() {
		Integer value = (Integer) getStateHelper().eval(PropertyKeys.tooltipDelay, 0);
		return (int) value;
	}

	/**
	 * The tooltip is shown and hidden with a delay. This value is the delay in
	 * milliseconds. Defaults to 0 (no delay).
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setTooltipDelay(int _tooltipDelay) {
		getStateHelper().put(PropertyKeys.tooltipDelay, _tooltipDelay);
	}

	/**
	 * The tooltip is hidden with a delay. This value is the delay in
	 * milliseconds. Defaults to 0 (no delay).
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public int getTooltipDelayHide() {
		Integer value = (Integer) getStateHelper().eval(PropertyKeys.tooltipDelayHide, 0);
		return (int) value;
	}

	/**
	 * The tooltip is hidden with a delay. This value is the delay in
	 * milliseconds. Defaults to 0 (no delay).
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setTooltipDelayHide(int _tooltipDelayHide) {
		getStateHelper().put(PropertyKeys.tooltipDelayHide, _tooltipDelayHide);
	}

	/**
	 * The tooltip is shown with a delay. This value is the delay in
	 * milliseconds. Defaults to 0 (no delay).
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public int getTooltipDelayShow() {
		Integer value = (Integer) getStateHelper().eval(PropertyKeys.tooltipDelayShow, 0);
		return (int) value;
	}

	/**
	 * The tooltip is shown with a delay. This value is the delay in
	 * milliseconds. Defaults to 0 (no delay).
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setTooltipDelayShow(int _tooltipDelayShow) {
		getStateHelper().put(PropertyKeys.tooltipDelayShow, _tooltipDelayShow);
	}

	/**
	 * Where is the tooltip to be displayed? Possible values: "top", "bottom",
	 * "right", "left", "auto", "auto top", "auto bottom", "auto right" and
	 * "auto left". Default to "bottom".
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getTooltipPosition() {
		String value = (String) getStateHelper().eval(PropertyKeys.tooltipPosition);
		return value;
	}

	/**
	 * Where is the tooltip to be displayed? Possible values: "top", "bottom",
	 * "right", "left", "auto", "auto top", "auto bottom", "auto right" and
	 * "auto left". Default to "bottom".
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setTooltipPosition(String _tooltipPosition) {
		getStateHelper().put(PropertyKeys.tooltipPosition, _tooltipPosition);
	}

	/**
	 * The button type, can be submit, button, reset ; default submit.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getType() {
		String value = (String) getStateHelper().eval(PropertyKeys.type);
		return value;
	}

	/**
	 * The button type, can be submit, button, reset ; default submit.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setType(String _type) {
		getStateHelper().put(PropertyKeys.type, _type);
	}

	/**
	 * Component(s) to be updated with ajax.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getUpdate() {
		String value = (String) getStateHelper().eval(PropertyKeys.update);
		return value;
	}

	/**
	 * Component(s) to be updated with ajax.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setUpdate(String _update) {
		getStateHelper().put(PropertyKeys.update, _update);
	}

	/**
	 * Button text.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getValue() {
		String value = (String) getStateHelper().eval(PropertyKeys.value);
		return value;
	}

	/**
	 * Button text.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setValue(String _value) {
		getStateHelper().put(PropertyKeys.value, _value);
	}
}
